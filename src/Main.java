
// java Main.java で実行できる、Java11あたりからjavacしなくてもできるようになった

// https://openjdk.org/jeps/512
// クラス宣言もstatic void main(String[] args)も不要に
void main() {

    // https://openjdk.org/jeps/512
    // System.out.println は IO.println()でも可能になった
    // 実はIOクラス内でSystem.out.printlnを呼んでいるだけ
    IO.println("Hello, World!");

    // System.inからreadLineしてくれる、IO.readln()もある
    var name = IO.readln("Your name: ");
    IO.println("Hello, " + name + "!");


    // https://openjdk.org/jeps/511
    // java.base モジュールに含まれるクラスは import なしで利用可能
    // ※java.time.LocalDateTimeはjava.baseに含まれる
    var now = LocalDateTime.now();
    IO.println("Now: " + now);

    // もちろんListやMapなどもimportなしで利用可能
    var list = List.of(1, 2, 3);
    IO.println("List: " + list);


    // https://openjdk.org/jeps/513
    // コンストラクタでthis()やsuper()の前に処理が書けるようになったため、
    // User内の実装が簡潔になった
    var user = new User("taro", "tanaka", 25);


    // https://openjdk.org/jeps/456
    // 未使用変数は _ で表現可能
    // catch (Exception _)やlambda式の引数などにも利用可能
    switch (user) {
        case User(var s, var _) -> IO.println("User: " + s);
    }
}