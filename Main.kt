interface User{
    val id:String
    val password:String
    fun generate()
}
abstract class Employee{
    protected var name:String
    private var salary:Int
    protected open var leader:String="สมชาย"
    abstract var role:String
    abstract fun report()

    constructor(name:String,salary:Int){
        this.name=name.ifEmpty { "Unknown" }
        this.salary=if(salary<15000) 15000 else salary
    }
    protected val formatSalary:String
        get() {
            return java.text.DecimalFormat("#,###.00").format(salary)
        }
    open fun display(){
        println("---ข้อมูลพนักงาน-----")
        println("ชื่อพนักงาน = $name")
        println("เงินเดือน = $formatSalary บาท")
    }
}
class Sale:Employee{
    private var area:String
    override var leader:String="สมหญิง"
    override var role:String="จำหน่ายสินค้าในบริษัท"
    constructor(sale_name:String,sale_salary:Int,sale_area:String):super(sale_name,sale_salary){
        this.area=sale_area
    }
    override fun display(){
        println("----------------")
        println("ชื่อพนักงาน = $name")
        println("เงินเดือน = $formatSalary บาท")
        println("พื้นที่รับผิดชอบ = $area")
        println("หัวหน้าแผนกฝ่ายขาย = $leader")
    }
    override fun report(){
        println("กำไรการขายสินค้า 1 ล้านบาท")
    }
}
class IT:Employee , User{
    private var exp:Int
    override var leader:String="สมปอง"
    override var role:String="พัฒนาและดูแลระบบในบริษัท"
    override val id="UIT_$name"
    override val password="UIT_$name"
    override fun generate(){
        println("ไอดีของคุณ $id")
        println("รหัสผ่าน $password")
    }
    constructor(it_name:String,it_salary:Int,it_exp:Int):super(it_name,it_salary){
        this.exp=it_exp
    }
    override fun display(){
        println("----------------")
        println("ชื่อพนักงาน = $name")
        println("เงินเดือน = $formatSalary บาท")
        println("ประสบการณ์ทำงาน = $exp ปี")
        println("หัวหน้าแผนกฝ่ายไอที = $leader")
    }
    override fun report(){
        println("พัฒนาระบบขายสินค้า v1.0")
    }
}
fun main(){
    val emp1=IT("โจ้",50000,10)
    val emp2=IT("ก้อง",50000,10)
//    val emp3=Sale("ก้อง",50000,"อุดรธานี")
    emp1.generate()
    emp2.generate()
}