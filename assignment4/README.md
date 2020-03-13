### Environment

1. Java8 + lambda
2. MySQL 5.7
3. Play framework
4. Ebean

### Step by step operation

1. Import  `dblp_abstract_dataset` to database `soc.pub_abstract` by executing `parser.PaperAbstractParser` in `ebean-backend`
2. Apply mallet  to classify papers into 10 categories, the result is in `composition.csv`.
3. Import the data to `soc.pub_category`
4. Add  APIs to display my result

### How to test

- Import `18655_Yanan Sun_lab4.sql` into your database;

- Run `ebean-backend` to start the backend server, the port should be 9000

- Run `Frontend` to start the frontend server

- Visit following address:

  - http://localhost:9001/

    <img src="C:\Users\hityn\AppData\Roaming\Typora\typora-user-images\image-20200313001508232.png" alt="image-20200313001508232" style="zoom:80%;" />

  - http://localhost:9001/getByCategory?categoryId=1

    <img src="C:\Users\hityn\AppData\Roaming\Typora\typora-user-images\image-20200313001616736.png" alt="image-20200313001616736" style="zoom:80%;" />

  - http://localhost:9001/detail?pubId=4197

    <img src="C:\Users\hityn\AppData\Roaming\Typora\typora-user-images\image-20200313001700904.png" alt="image-20200313001700904" style="zoom:80%;" />

  - 

  