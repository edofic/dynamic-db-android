implicit class Converter(val value: Any) extends AnyVal{
  def blob = value.asInstanceOf[Array[Byte]]
  def double = value.asInstanceOf[Double]
  def long = value.asInstanceOf[Long]
  def string = value.asInstanceOf[String]
}
