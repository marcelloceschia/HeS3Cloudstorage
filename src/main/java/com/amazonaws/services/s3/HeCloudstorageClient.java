package com.amazonaws.services.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.Region;

/**
 * Wrapper for @see <a href="http://www.hosteurope.de/Cloud/#Cloud>Hosteuropes Cloud Storage</a> 
 * usung @see <a href="https://github.com/aws/aws-sdk-java>aws-java-sdk</a>
 * @author Marcello Ceschia
 */
public class HeCloudstorageClient extends AmazonS3Client {
    private static String SERVER_NAME = "cs.hosteurope.de";

    public HeCloudstorageClient() {
        super();
        this.setEndpoint("https://" + SERVER_NAME);
    }

    public HeCloudstorageClient(AWSCredentials awsCredentials) {
        super(awsCredentials);
        this.setEndpoint("https://" + SERVER_NAME);
    }

    public HeCloudstorageClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(awsCredentials, clientConfiguration);
        this.setEndpoint("https://" + SERVER_NAME);
    }

    public HeCloudstorageClient(AWSCredentialsProvider credentialsProvider) {
        super(credentialsProvider);
        this.setEndpoint("https://" + SERVER_NAME);
    }

    public HeCloudstorageClient(ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.setEndpoint("https://" + SERVER_NAME);
    }

    public HeCloudstorageClient(AWSCredentialsProvider credentialsProvider, ClientConfiguration clientConfiguration) {
        super(credentialsProvider, clientConfiguration);
        this.setEndpoint("https://" + SERVER_NAME);
    }
    
    
    @Override
    public Bucket createBucket(String bucketName) throws AmazonClientException, AmazonServiceException {
        return super.createBucket(new CreateBucketRequest(bucketName, SERVER_NAME));
    }
    
    /**
     * 
     * @param bucketName
     * @param region - will be replaced by cs.hosteurope.de
     * @return new Bucket Obkect
     * @throws AmazonClientException
     * @throws AmazonServiceException 
     */
    @Override
    public Bucket createBucket(String bucketName, Region region) throws AmazonClientException, AmazonServiceException {
        return super.createBucket(new CreateBucketRequest(bucketName, SERVER_NAME));
    }
    
    /**
     * 
     * @param bucketName
     * @param region will be ignored and replaced by cs.hosteurope.de
     * @return
     * @throws AmazonClientException
     * @throws AmazonServiceException 
     */
    @Override
    public Bucket createBucket(String bucketName, String region) throws AmazonClientException, AmazonServiceException {
        return super.createBucket(new CreateBucketRequest(bucketName, SERVER_NAME));
    }
    
    /**
     * Creates a new bucket for createBucketRequest. The region setting in CreateBucketRequest will be replaced by cs.hosteurope.de
     * 
     * @param createBucketRequest
     * @return
     * @throws AmazonClientException
     * @throws AmazonServiceException 
     */
    @Override
    public Bucket createBucket(CreateBucketRequest createBucketRequest) throws AmazonClientException, AmazonServiceException {
        createBucketRequest.setRegion(SERVER_NAME);
        return super.createBucket(createBucketRequest);
    }
}
