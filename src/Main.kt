// scope fonksiyonlar: let, run(2 kullanımı var), with, apply, and also dur.

// 1) bir scope fonksiyonu kullanırken değişkenlerin değerini değiştireceksek mesela name="Eylem name = "Bilecik"
// olarak değişecekse ya da nesne oluşturulacaksa apply ya da also kullanılır. Eğer değişken değeri
// manipüle edilmeyecekse yani değiştirilmeyecekse ve nesne oluşturulmayacaksa   with,run,let'den biri kullanılabilir.

//2)bir değişken zaten oluşturulduysa ve var olan değişken nullable değilse  with kullanılır.

//2a) bir değişken zaten oluşturulduysa ve var olan değişken nullable ise ve aynı zamanda bir değer atayacaksak
// ?.let sonra ?:run kullanılır (?: = elvis)

//2b)bir değişken zaten oluşturulduysa ve var olan değişken nullable ise  ama bir değer atamayacaksak
// önce ?.also sonra ?:run.


data class User(var name: String, val age: Int)

class Student {
    var name: String = ""
    var age: Int = 0
}

fun main() {
    val student1 = Student().apply {
        name = "Gölge"
        age = 25
    }

    val student2 = Student().also {
        it.name = "Aylin"
        it.age = 30
    }

    println(student1.name)
    println(student2.name)

    val name: String? = "Eylem"

    // Nullable değişkenle çalışırken let kullanımı
    val returnValueLet = name?.let {
        println("let: $it")
    }

    // Nullable değişkenle çalışırken run kullanımı
    val returnValueRun = name?.run {
        println("run: $this")
    }

    // Genel bir kod bloğu çalıştıran run
    val returnValueRun2 = run {
        println("run without receiver")
    }

    // Nullable olmayan değişkenle with kullanımı
    val returnValueWith = with(name) {
        println("with: $this")
    }

    // apply, nullable veya null olmayan değerlerde kullanılabilir
    val returnValueApply = name.apply {
        println("apply: $this")
    }

    // also, nullable veya null olmayan değerlerde kullanılabilir
    val returnValueAlso = name.also {
        println("also: $it")
    }
}
