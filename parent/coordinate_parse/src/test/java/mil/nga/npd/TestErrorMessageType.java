package mil.nga.npd;

import org.junit.Test;

import mil.nga.npd.types.CoordinateParseErrorMessageType;

import org.junit.Assert;

public class TestErrorMessageType {

    @Test
    public void testGetErrorMessage() {
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.UNKNOWN_ERROR.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("1"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.UNKNOWN_ERROR.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("3.14159"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.UNKNOWN_ERROR.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1000"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1001.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1001"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1002.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1002"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1003.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1003"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1004.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1004"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1005.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1005"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1006.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1006"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1007.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1007"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1008.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1008"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1009.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1009"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1010.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1010"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1011.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1011"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1012.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1012"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1013.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1013"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1014.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1014"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1015.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1015"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1016.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1016"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1017.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1017"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1018.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1018"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1019.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1019"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1020.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1020"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1021.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1021"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1022.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1022"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1023.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1023"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1024.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1024"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1025.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1025"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1026.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1026"));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1027.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage("-1027"));
    }
    
    @Test
    public void testGetErrorMessageDbl() {
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.UNKNOWN_ERROR.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(1));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.UNKNOWN_ERROR.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(3.14159));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.UNKNOWN_ERROR.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1000));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1001.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1001));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1002.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1002));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1003.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1003));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1004.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1004));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1005.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1005));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1006.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1006));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1007.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1007));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1008.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1008));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1009.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1009));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1010.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1010));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1011.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1011));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1012.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1012));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1013.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1013));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1014.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1014));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1015.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1015));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1016.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1016));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1017.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1017));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1018.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1018));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1019.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1019));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1020.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1020));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1021.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1021));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1022.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1022));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1023.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1023));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1024.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1024));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1025.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1025));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1026.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1026));
        
        Assert.assertEquals(
                CoordinateParseErrorMessageType.ERROR_MINUS_1027.getErrorMessage(), 
                CoordinateParseErrorMessageType.getErrorMessage(-1027));
    }
}
