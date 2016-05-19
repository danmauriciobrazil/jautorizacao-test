package br.com.cabal.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sleepycat.je.utilint.Timestamp;

public class DateTest {

	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	final static int _10ANOS = 10;
	
    
//	Date dataAtual = calendar.getTime();
//	System.out.println(df.format(dataAtual));
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.YEAR, + _10ANOS);
		new Timestamp(calendar.getTimeInMillis());
	}
}
