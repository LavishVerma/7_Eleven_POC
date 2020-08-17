package com.example.Zuul_API_Gateway;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Scheduler {

	
	public static void main(String[] args) {
		
		String[] list= {"mon-5am-6pm","tue-10am-10pm","mon-10am-8pm","sat-12pm-03pm","wed-11am-1pm"};
		schedule[] sc= new schedule[list.length];
		
		for (int i=0; i<list.length; i++) 
		{
		    sc[i]=new schedule();
			String[] split = list[i].split("-");
			sc[i].setDay(DAYS.valueOf(split[0]).getNumVal());
			sc[i].setstarttime(split[1]);
			sc[i].setendtime(split[2]);	
	    }
		
		
		for(int j=0;j<sc.length;j++)
		{
			System.out.println(sc[j].getDay()+" "+sc[j].getstarttime()+" "+sc[j].getendtime());
		}
//		 Date dNow = new Date( );
//	      SimpleDateFormat ft = 
//	      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//
//	      System.out.println("Current Date: " + ft.format(dNow));
	}

}
class schedule{
    private Integer day;
    private String starttime;
    private String endtime;
    
    public void setDay(Integer day) {
    	this.day=day;
    }
    public void setstarttime(String day) {
    	this.starttime=day;
    }
    public void setendtime(String day) {
    	this.endtime=day;
    }
    
    public Integer getDay() {
    	return this.day;
    }
    public String getstarttime() {
    	return this.starttime;
    }
    public String getendtime() {
    	return this.endtime;
    }
}
enum DAYS{
	mon(1),tue(2),wed(3),thr(4),fri(5),sat(6),sun(7);
	private int numVal;

    DAYS(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
