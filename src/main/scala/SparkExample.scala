import org.apache.spark.{SparkConf, SparkContext}



object SparkExample {

  private val master = "local[2]"
  private val appName = "example-spark"
  private val stopWords = Set("a", "an", "the")
  System.setProperty("hadoop.home.dir", "C:\\winutils")
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setMaster(master)
      .setAppName(appName)

    val sc = new SparkContext(conf)

    val lines = sc.textFile("C:\\Users\\supratimdas\\IdeaProjects\\SparkTester\\data\\kjvdat.txt")
    val wordsCount = WordCount.count(sc, lines, stopWords)

    val counts = wordsCount.collect().mkString("[", ", ", "]")
//    print(counts)
  }
}