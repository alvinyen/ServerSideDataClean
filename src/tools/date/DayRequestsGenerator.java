package tools.date;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DayRequestsGenerator {
	
	public DayRequestsGenerator(){}
	public DayRequestsGenerator(String source,String output){
		//this.source=source;
		//this.output=output;
	}
	public static void generate(String from,String end,String vm,String s_date){
		String outputSource="/Users/KJ-Yen/NCHC_ServerSideAdLoggingData_test/dataProcess/4final/"+vm+"/";
		String source="/Users/KJ-Yen/NCHC_ServerSideAdLoggingData_test/dataProcess/4final/"+vm+"/"+s_date+".csv";
		//String output="/Users/KJ-Yen/aDayDateTime3_2016-06-01-00_00_00_00000.csv";
		String output2=outputSource+"aDayMsReqs2_"+s_date+".csv";
		String output3=outputSource+"aDayMs1_"+s_date+".csv";
		String output4=outputSource+"aDayReqs1_"+s_date+".csv";
		
		
		BufferedReader br=null;
		//BufferedWriter bw=null;
		BufferedWriter bw2=null;
		BufferedWriter bw3=null;
		BufferedWriter bw4=null;
		String aLine=null;
		
		try {
			
			br=new BufferedReader(new FileReader(new File(source)));
			//bw=new BufferedWriter(new FileWriter(new File(output)));
			bw2=new BufferedWriter(new FileWriter(new File(output2)));
			bw3=new BufferedWriter(new FileWriter(new File(output3)));
			bw4=new BufferedWriter(new FileWriter(new File(output4)));
			aLine=br.readLine();
			//System.out.println(aLine);
			for(long l=DateMsParser.convertToMs(from);l<DateMsParser.convertToMs(end);l++){
				
					if( (aLine!=null) && (DateMsParser.convertToMs(aLine.split(",")[0]).longValue() == l) ){
						//***
						//bw.write(aLine+","+l+"\n");
						bw2.write(l+","+aLine.split(",")[1]+"\n");
						bw3.write(l+"\n");
						bw4.write(aLine.split(",")[1]+"\n");
						//bw.flush();
						bw2.flush();
						bw3.flush();
						bw4.flush();
						aLine=br.readLine();
					}else{
						//bw.write(DateMsParser.convertToDateString(l)+","+0+","+l+"\n");
						bw2.write(l+","+0+"\n");
						//bw.flush();
						bw3.write(l+"\n");
						bw4.write(0+"\n");
						bw2.flush();
						bw3.flush();
						bw4.flush();
					}
				
			}

			//bw.flush();
			bw2.flush();
			bw3.flush();
			bw4.flush();
			//bw.close();
			bw2.close();
			bw3.close();
			bw4.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not found...");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IOException... in bw ??");
		} finally{
			try {
				br.close();
				//bw.close();
				bw2.close();
				bw3.close();
				bw4.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("br close failed in finally");
			}
			System.out.println("done..");
		}
	}
	public static void main(String[] args){
		//String[] vms={"189","195","196","197","198"};
		String[] vms={"189"};
		String[] date={"2016-05-25","2016-05-26","2016-05-27","2016-05-28","2016-05-29","2016-05-30","2016-05-31","2016-06-01","2016-06-02","2016-06-03","2016-06-04","2016-06-05","2016-06-06","2016-06-07","2016-06-08","2016-06-09","2016-06-10","2016-06-11","2016-06-12","2016-06-13","2016-06-14","2016-06-15"};
		for(int i=0;i<vms.length;i++){
			for(int j=0;j<date.length-1;j++){
				DayRequestsGenerator.generate(date[j]+" 00:00:00.000", date[j+1]+" 00:00:00.000",vms[i],date[j]);
			}
			
		}
		
	}
}
