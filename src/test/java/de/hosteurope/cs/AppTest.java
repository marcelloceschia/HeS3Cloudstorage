package de.hosteurope.cs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.HeCloudstorageClient;
import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.ByteArrayInputStream;
import java.util.UUID;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private static String accessKey = null;
    private static String secretKey = null;
    
    
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testAccesskeySet(){
        assertNotNull("You have to set the accessKey to proceed the test", accessKey);
        assertNotNull("You have to set the secretKey to proceed the test", secretKey);
    }
    
    
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        
        
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 conn = new HeCloudstorageClient (credentials);
        
        String containerName = "de.hosteurope.s3.client.test." + UUID.randomUUID().toString().replace("-", "");
        System.out.println(containerName);
        if (!conn.doesBucketExist(containerName)){
            conn.createBucket(containerName);
        }
        
        ByteArrayInputStream input = new ByteArrayInputStream("Hello World!".getBytes());
        conn.putObject(containerName, "hello.txt", input, new ObjectMetadata());

    }
}
