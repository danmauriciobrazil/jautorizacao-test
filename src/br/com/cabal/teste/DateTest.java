package br.com.cabal.teste;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.tools.ant.util.DateUtils;

import com.sleepycat.je.utilint.Timestamp;

import br.com.cabal.jautorizacao.util.UtilMensagemIso;

public class DateTest {

	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	final static int _10ANOS = 10;
	
    
	public static void main(String[] args) {
		System.out.println(UtilMensagemIso.getPathPackageJpos());
	}
}
