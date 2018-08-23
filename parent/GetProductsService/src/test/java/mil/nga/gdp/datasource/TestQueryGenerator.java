package mil.nga.gdp.datasource;

import static org.junit.Assert.*;

import org.junit.Test;

import mil.nga.gdp.exceptions.IllegalTypeException;

/**
 * JUnit test class for <code>mil.nga.gdp.QueryGenerator</code>.
 * @author L. Craig Carpenter
 */
public class TestQueryGenerator {

	@Test
	public void testGetQueryByFIPSCode() {
		QueryGenerator queryGen = new QueryGenerator();
		assertEquals(
				" FIPS_CODE like 'AU'", 
				queryGen.getQueryByFIPSCode("AU", null));
		assertEquals(
				" FIPS_CODE like 'AU'", 
				queryGen.getQueryByFIPSCode("au", null));
		assertEquals(
				" JUMP_CODE like 'US_MO'", 
				queryGen.getQueryByFIPSCode("US", "MO"));
		assertEquals(
				" JUMP_CODE in ('US','US_AK','US_HI')", 
				queryGen.getQueryByFIPSCode("US", null));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testGetQueryByFIPSCodeBAD() {
		QueryGenerator queryGen = new QueryGenerator();
		queryGen.getQueryByFIPSCode(null, null);
	}
	
	@Test
	public void testGetQueryByISOCode() {
		QueryGenerator queryGen = new QueryGenerator();
		assertEquals(
				" ISO3CHR like 'AUS'", 
				queryGen.getQueryByISOCode("AUS", null));
		assertEquals(
				" ISO3CHR like 'AUS'", 
				queryGen.getQueryByISOCode("aus", null));
		assertEquals(
				" JUMP_CODE like 'US_MO'", 
				queryGen.getQueryByISOCode("USA", "MO"));
		assertEquals(
				" JUMP_CODE in ('US','US_AK','US_HI')", 
				queryGen.getQueryByISOCode("USA", null));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testGetQueryByISOCodeBAD() {
		QueryGenerator queryGen = new QueryGenerator();
		queryGen.getQueryByISOCode(null, null);
	}
	
	@Test
	public void testGetQueryByCommand() throws IllegalTypeException {
		QueryGenerator queryGen = new QueryGenerator();
		assertEquals(
				" AOR_CODE like 'CENTCOM'", 
				queryGen.getQueryByCommand("centcom"));
		assertEquals(
				" AOR_CODE like 'PACOM'", 
				queryGen.getQueryByCommand("pacom"));
		assertEquals(
				" AOR_CODE like 'AFRICOM'", 
				queryGen.getQueryByCommand("africom"));
		assertEquals(
				" AOR_CODE like 'EUCOM'", 
				queryGen.getQueryByCommand("EUCOM"));
		assertEquals(
				" AOR_CODE like 'NORTHCOM'", 
				queryGen.getQueryByCommand("NORTHCOM"));
		assertEquals(
				" AOR_CODE like 'SOUTHCOM'", 
				queryGen.getQueryByCommand("SOUTHCOM"));
	}
	
	@Test(expected = IllegalTypeException.class)
	public void testGetQueryByCommandBAD1() throws IllegalTypeException {
		QueryGenerator queryGen = new QueryGenerator();
		queryGen.getQueryByCommand("WORLDCOM");
	}
	
	@Test(expected = IllegalTypeException.class)
	public void testGetQueryByCommandBAD2() throws IllegalTypeException {
		QueryGenerator queryGen = new QueryGenerator();
		queryGen.getQueryByCommand(null);
	}
	
	@Test
	public void testGetQueryByJumpCode() {
		QueryGenerator queryGen = new QueryGenerator();
		assertEquals(
				" JUMP_CODE like 'ABCD'", 
				queryGen.getQueryByJumpCode("ABCD"));
		assertEquals(
				" JUMP_CODE like 'DEFG'", 
				queryGen.getQueryByJumpCode("defg"));
		assertEquals(
				" JUMP_CODE like 'HIJK'", 
				queryGen.getQueryByJumpCode(" hijk "));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testGetQueryByJumpCodeBAD() {
		QueryGenerator queryGen = new QueryGenerator();
		queryGen.getQueryByJumpCode(null);
	}
	
	@Test
	public void testGetDateWhereClause() {
		QueryGenerator queryGen = new QueryGenerator();
		assertEquals(
				"", 
				queryGen.getDateWhereClause(null, null));
		assertEquals(
				" LOAD_DATE >= to_date('2018-06-01')", 
				queryGen.getDateWhereClause("2018-06-01", null));
		assertEquals(
				" LOAD_DATE >= to_date('2018-06-01') and LOAD_DATE <= to_date('2018-06-11')",
				queryGen.getDateWhereClause("2018-06-01", "2018-06-11"));
		assertEquals(
				" LOAD_DATE >= to_date('2018-06-05')", 
				queryGen.getDateWhereClause("2018-06-05", "2018-06-05"));
		assertEquals(
				" LOAD_DATE <= to_date('2018-06-01')", 
				queryGen.getDateWhereClause("", "2018-06-01"));
	}
	
}
