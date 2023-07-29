package com.example.designpatternsapp.iteratormodel

 interface Company{
    fun  iterator(): Iterator<Employee>
}

class CompanyMin() : Company{

    private val employees: MutableList<Employee>

    init {
        employees = mutableListOf<Employee>()
        employees.add(
            Employee("小民"  , 96 , "男" , "程序猿")
        )
        employees.add(
            Employee("小芸"  , 22 , "女" , "测试")
        )
        employees.add(
            Employee("小方"  , 18 , "女" , "测试")
        )
        employees.add(
            Employee("可儿"  , 21 , "女" , "设计")
        )
    }

    override fun iterator(): Iterator<Employee> {
        return MinIterator(employees)
    }
}

class CompanyHui : Company{

    private val employees: ArrayList<Employee>

    init {
        employees = ArrayList<Employee>(3).apply {
            add(Employee("辉哥"  , 108 , "男" , "程序猿"))
            add(Employee("小红"  , 98 , "男" , "程序猿"))
            add(Employee("小辉"  , 88 , "男" , "程序猿"))
        }


    }

    override fun iterator(): Iterator<Employee> {
        return HuiIterator(employees.toTypedArray())
    }
}

