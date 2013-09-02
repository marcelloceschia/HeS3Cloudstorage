#How to use

```
AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
AmazonS3 conn = new HeCloudstorageClient (credentials);

String containerName = "bucket.name." + UUID.randomUUID().toString().replace("-", "");
if (!conn.doesBucketExist(containerName)){
  conn.createBucket(containerName);
}

ByteArrayInputStream input = new ByteArrayInputStream("Hello World!".getBytes());
conn.putObject(containerName, "hello.txt", input, new ObjectMetadata());
```
