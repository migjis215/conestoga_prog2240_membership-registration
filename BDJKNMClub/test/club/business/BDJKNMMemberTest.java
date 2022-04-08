package club.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jisung Kim
 */
public class BDJKNMMemberTest {
    
    public BDJKNMMemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFullName method, of class BDJKNMMember.
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        BDJKNMMember instance = new BDJKNMMember();
        String expResult = "Jisung Kim";
        instance.setFullName(expResult);
        String result = instance.getFullName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

//    /**
//     * Test of setFullName method, of class BDJKNMMember.
//     */
//    @Test
//    public void testSetFullName() {
//        System.out.println("setFullName");
//        String fullName = "";
//        BDJKNMMember instance = new BDJKNMMember();
//        instance.setFullName(fullName);
//        // TODO review the generated test code and remove the default call to fail.
//        // fail("The test case is a prototype.");
//    }

    /**
     * Test of getEmailAddress method, of class BDJKNMMember.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        BDJKNMMember instance = new BDJKNMMember();
        String expResult = "jkim3240@conestogac.on.ca";
        instance.setEmailAddress(expResult);
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

//    /**
//     * Test of setEmailAddress method, of class BDJKNMMember.
//     */
//    @Test
//    public void testSetEmailAddress() {
//        System.out.println("setEmailAddress");
//        String emailAddress = "";
//        BDJKNMMember instance = new BDJKNMMember();
//        instance.setEmailAddress(emailAddress);
//        // TODO review the generated test code and remove the default call to fail.
//        // fail("The test case is a prototype.");
//    }

    /**
     * Test of getPhoneNumber method, of class BDJKNMMember.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        BDJKNMMember instance = new BDJKNMMember();
        String expResult = "416-454-6875";
        instance.setPhoneNumber(expResult);
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

//    /**
//     * Test of setPhoneNumber method, of class BDJKNMMember.
//     */
//    @Test
//    public void testSetPhoneNumber() {
//        System.out.println("setPhoneNumber");
//        String phoneNumber = "";
//        BDJKNMMember instance = new BDJKNMMember();
//        instance.setPhoneNumber(phoneNumber);
//        // TODO review the generated test code and remove the default call to fail.
//        // fail("The test case is a prototype.");
//    }

    /**
     * Test of getProgramName method, of class BDJKNMMember.
     */
    @Test
    public void testGetProgramName() {
        System.out.println("getProgramName");
        BDJKNMMember instance = new BDJKNMMember();
        String expResult = "CPA";
        instance.setProgramName(expResult);
        String result = instance.getProgramName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

//    /**
//     * Test of setProgramName method, of class BDJKNMMember.
//     */
//    @Test
//    public void testSetProgramName() {
//        System.out.println("setProgramName");
//        String programName = "";
//        BDJKNMMember instance = new BDJKNMMember();
//        instance.setProgramName(programName);
//        // TODO review the generated test code and remove the default call to fail.
//        // fail("The test case is a prototype.");
//    }

    /**
     * Test of getYearLevel method, of class BDJKNMMember.
     */
    @Test
    public void testGetYearLevel() {
        System.out.println("getYearLevel");
        BDJKNMMember instance = new BDJKNMMember();
        int expResult = 2;
        instance.setYearLevel(expResult);
        int result = instance.getYearLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

//    /**
//     * Test of setYearLevel method, of class BDJKNMMember.
//     */
//    @Test
//    public void testSetYearLevel() {
//        System.out.println("setYearLevel");
//        int yearLevel = 0;
//        BDJKNMMember instance = new BDJKNMMember();
//        instance.setYearLevel(yearLevel);
//        // TODO review the generated test code and remove the default call to fail.
//        // fail("The test case is a prototype.");
//    }

    /**
     * Test of isValid method for positive test, of class BDJKNMMember.
     */
    @Test
    public void testValidPositive() {
        System.out.println("isValidPositive");
        BDJKNMMember instance = 
                new BDJKNMMember("Jisung Kim", "jkim3240@conestogac.on.ca");
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    /**
     * Test of isValid method for negative test, of class BDJKNMMember.
     */
    @Test
    public void testValidNegative() {
        System.out.println("isValidNegative");
        BDJKNMMember instance = new BDJKNMMember();
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}
