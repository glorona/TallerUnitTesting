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

}
