package App;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testare {


	@Test
	void GreutatePozitiva() throws Integer_pozitiv 
	{
		Integerpozitiv.Verificare(48);
	}

	@Test
	void GreutateNegativa() {
		try {
			Integerpozitiv.Verificare(-12);
			fail();
		}catch(Integer_pozitiv e){
			
	}
		}

	@Test
	void GreutateNula() {
		try {
			Integerpozitiv.Verificare(0);
			fail();
		}catch(Integer_pozitiv e){
			
	}
		}
	
	
	@Test
	void EmailCorect() throws String_email {
			 Stringemail.Verificare("nume@gmail.com");
	}

	
	
	@Test
	void EmailGresit1() throws String_email {
		try {
			 Stringemail.Verificare("nume@");
			fail();
			}catch(String_email e){

			}

		}
	
	@Test
	void EmailGresit2() throws String_email {
		try {
			 Stringemail.Verificare("numegmail.com");
			fail();
			}catch(String_email e){

			}

		}
	
	@Test
	void EmailGresit3() throws String_email {
		try {
			 Stringemail.Verificare("@gmail.com");
			fail();
			}catch(String_email e){

			}

		}
	
	
	@Test
	void TelefonGresit1() throws String_telefon{
		try {
			 Stringtelefon.Verificare("1234567890");
			fail();
			}catch(String_telefon e){

			}

		}
	
	@Test
	void TelefonCorect() throws String_telefon{
			
		Stringtelefon.Verificare("0722363655");
			}

	
	
	@Test
	void TelefonGresit2() throws String_telefon{
		try {
			 Stringtelefon.Verificare("0123456789");
			fail();
			}catch(String_telefon e){

			}

		}
	
	@Test
	void TelefonGresit3() throws String_telefon{
		try {
			 Stringtelefon.Verificare("07245641259");
			fail();
			}catch(String_telefon e){

			}

		}
	
	@Test
	void TelefonGresit4() throws String_telefon{
		try {
			 Stringtelefon.Verificare("072456412");
			fail();
			}catch(String_telefon e){

			}

		}
	
	
	@Test
	void TelefonGresit5() throws String_telefon{
		try {
			 Stringtelefon.Verificare("0726@53$45");
			fail();
			}catch(String_telefon e){

			}

		}
	
	@Test
	void EmptyString() throws String_gol{
		try {
			 Stringgol.Verificare("");
			fail();
			}catch(String_gol e){

			}

		}
	
	@Test
	void StringNotEmpty() throws String_gol{
	
			 Stringgol.Verificare("string");
		
			}

	@Test
	void NumeGresit1() throws String_nume{
		try {
			 Stringnume.Verificare("Popescu");
			fail();
			}catch(String_nume e){

			}

		}
	
	@Test
	void NumeGresit2() throws String_nume{
		try {
			 Stringnume.Verificare("popescu mihai");
			fail();
			}catch(String_nume e){

			}

		}
	
	@Test
	void NumeGresit3() throws String_nume{
		try {
			 Stringnume.Verificare("Popescu mihai");
			fail();
			}catch(String_nume e){

			}

		}
	
	@Test
	void NumeGresit4() throws String_nume{
		try {
			 Stringnume.Verificare("PopescuMihai");
			fail();
			}catch(String_nume e){

			}

		}
	
	
	@Test
	void NumeCorect() throws String_nume{
		
			 Stringnume.Verificare("Popescu Mihai");

		}
	
	@Test
	void CardVisaGresit1() throws String_card{
		try {
			 Stringcard.Verificare("1234123412341234");
			fail();
			}catch(String_card e){

			}

		}
	
	
	@Test
	void CardVisaGresit2() throws String_card{
		try {
			 Stringcard.Verificare("41112222333344445");
			fail();
			}catch(String_card e){

			}

	}
	
	
	@Test
	void CardVisaGresit3() throws String_card{
		try {
			 Stringcard.Verificare("411122223333");
			fail();
			}catch(String_card e){

			}

	}
	
	
	@Test
	void CardVisaCorect() throws String_card{
	
			 Stringcard.Verificare("4234123412341234");

	}
		
	
	@Test
	void CVVgresit1() throws String_cvv{
		try {
			 Stringcvv.Verificare("1234");
			fail();
			}catch(String_cvv e){

			}

	}
	
	
	@Test
	void CVVgresit2() throws String_cvv{
		try {
			 Stringcvv.Verificare("3@4");
			fail();
			}catch(String_cvv e){

			}

	}
	
	@Test
	void CVVcorect1() throws String_cvv{
	
			 Stringcvv.Verificare("078");
	
			}

	
@	Test
	void CVVcorect2() throws String_cvv{

		 Stringcvv.Verificare("935");

		}
	
	
	
	
	
}
