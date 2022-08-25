package testTallerPruebas;


import tallerPruebas.Employee;
import tallerPruebas.EmployeeType;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestEmployee {
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testConstructor() {
		Employee e1 = new Employee( 400.0F, "USD", 5.5F, EmployeeType.Manager);
		assertNotNull("Constructor distinto de Null", e1);
	}
	
	
	@Test 
	public void testCs() {
		
		Clock baseClock = Clock.fixed(Instant.now(),ZoneId.systemDefault());
		
		
		Employee e2 = new Employee( 600.0F, "GBP", 2.5F, EmployeeType.Worker);
		Employee e3 = new Employee( 400.0F, "USD", 1.5F, EmployeeType.Worker);
		
		
		
		Clock clock = Clock.offset(baseClock,Duration.ofDays(30));
		
		
		
		
		
		//Probado con Mes Par
		assertEquals("Moneda Distinta", 600.0F*0.95F, e2.cs(), 0);
		
	
		assertEquals("Mes Impar", 400.0F + 386.0F/12*2, e3.cs(),0);
	}
	
	
	@Test 
	public void testCalculateYearBonus() {
		
			
		Employee e4 = new Employee( 500.0F, "EURO", EmployeeType.Worker);
		Employee e5 = new Employee( 400.0F, "USD", EmployeeType.Supervisor);
		Employee e6 = new Employee( 450.0F, "USD", EmployeeType.Manager);
		Employee e7 = new Employee( 350.0F, "USD", EmployeeType.Worker);
		
		
		
		
		//moneda diferente al dolar
		assertEquals("Moneda Distinta", 570F, e4.CalculateYearBonus(), 0);
		
		//moneda de dolar
		//supervisor
		assertEquals("Moneda Dolar", 593F, e5.CalculateYearBonus(),0);
	}
	
	//manager
	
	assertEquals("Moneda Dolar", 836F, e6.CalculateYearBonus(),0);
}

	//worker
    assertEquals("Moneda Dolar", 350.0F , e7.CalculateYearBonus(),0);
}
	
	/*/system.out.print(Calendar.getInstance())
	Instant nowUtc = Instant.now();
	ZoneId americaGuayaquil = ZoneId.of("America/Guayaquil");
	ZonedDateTime nowAmericaGuayaquil = ZonedDateTime.ofInstant(nowUtc, americaGuayaquil);
	
	import java.text.DateFormat;
	import java.util.Date;
	import java.util.Locale;
	import java.util.TimeZone;

	public class Main {
	    public static void main(String[] args) {
	        Locale locale = Locale.getDefault();
	        TimeZone localTimeZone = TimeZone.getDefault(); 
	        //TimeZone localTimeZone = TimeZone.getTimeZone("America/Guayaquil");
	        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
	        dateFormat.setTimeZone(localTimeZone);
	        Date rightNow = new Date();
	        System.out.println(locale.toString() + ": " + dateFormat.format(rightNow));
	    }
	}*/
	
	
}
