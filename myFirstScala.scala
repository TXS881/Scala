import org.apache.spark.sql.SparkSession

object FirstScala {
  def main(args: Array[String]): Unit = {
    println("bhala ta")
    //For Windows
    System.setProperty("hadoop.home.dir", "C:\\Winutils")
    val sc= SparkSession.builder()
      .appName("FirstScala")
      .config("spark.master","local")
      .enableHiveSupport()
      .getOrCreate()

    var dt = Seq(("a",1),("b",5),("a",15),("ab",17),("a",10))
    var nm = sc.createDataFrame(dt).toDF("name","age")
    nm.write.format("csv").save("first_csv")
    nm.show()

  }
}
