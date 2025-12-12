package com.contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContactManagerTest {

	ContactManager cm;
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("Before All");
	}
	
	@BeforeEach
	public void setup() {
		cm = new ContactManager();
	}
	
	@Test
	@EnabledOnOs(value = OS.LINUX, disabledReason = "For Linux")
	public void shouldCreateContact() {
		cm.addContact("test", "test", "0123456789");
		assertFalse(cm.getAllContacts().isEmpty());
		assertEquals(1,  cm.getAllContacts().size());
	}

	@Disabled
	public void shouldThrowRunTimeExceptionWhenFirstNameIsNull()
	{
		assertThrows(RuntimeException.class, ()-> cm.addContact(null, "dfsd", "3432"));
	}
	
	
	//Do Same for LastName
	
	@Nested
	class ParameterizedClass{
		@DisplayName("Parameterized Test..")
		@ParameterizedTest
		@ValueSource(strings ={"0123456789", "1234567898", "04545645455"})
		public void shouldTestContactCreationUsingValueSource(String phone) {
			cm.addContact("fd", "ffdf", phone);
		}
		
	}
	
}
