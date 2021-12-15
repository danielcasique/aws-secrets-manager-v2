# How to implement AWS Secrets Manager JDBC

## Overview
Implementation of the example from the following [link](https://cloudemployee.co.uk/blog/productivity/integrate-aws-secrets-manager-with-springboot).

## Prerequisites 
- Follow the instructions on [here](https://cloudemployee.co.uk/blog/productivity/integrate-aws-secrets-manager-with-springboot) to set the MySQL aws database and AWS Secrets manager.
- Create the following tables on ```testdb```:
```
CREATE TABLE `product` (
    `name` varchar(30) NOT NULL, 
    `quantity` int(11) NOT NULL,   
    `id` bigint(20) NOT NULL,  
    PRIMARY KEY (`id`)) COMMENT='product table';
    
create table hibernate_sequence(
  next_val INTEGER NOT null);
  
insert into hibernate_sequence values(1);.
```

## Common issues
```
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [javax.sql.DataSource]: Factory method 'dataSource' threw exception; nested exception is com.amazonaws.services.secretsmanager.model.AWSSecretsManagerException: The security token included in the request is invalid. (Service: AWSSecretsManager; Status Code: 400; Error Code: UnrecognizedClientException; Request ID: 4880ebc0-59ed-49e6-abc5-6ba535e942eb; Proxy: null)
```
To solve this issue try to add the AWS environment variables:: AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY and AWS_DEFAULT_REGION

```
com.zaxxer.hikari.pool.HikariPool$PoolInitializationException: Failed to initialize pool: The request signature we calculated does not match the signature you provided. Check your AWS Secret Access Key and signing method. Consult the service documentation for details. (Service: AWSSecretsManager; Status Code: 400; Error Code: InvalidSignatureException; Request ID: 9a356a2b-b8fe-4810-ae28-08b1b9ec939d)
```
To solve this issue try to add the encoding setting ```-Dfile.encoding=UTF-8```. More info [here](https://stackoverflow.com/questions/70367617/awssecretsmanagerexception-the-request-signature-we-calculated-does-not-match-t)