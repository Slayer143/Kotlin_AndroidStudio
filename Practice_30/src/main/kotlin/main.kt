
fun main() {

//    val frst = Regex("""[Cc][Aa][Ss][Ee]\s[A-Za-z_][A-Za-z_0-9]*\s+[Oo][Ff]\s*?""") //ready (see CaSe)
//
//    val scnd = Regex("""('[A-Za-z_0-9%`~!@#$^&*()\[\]{}?/|\\><.,;"№\-=+]'|''''|#[0-9][0-9]?)\s*(((,|\.\.)\s*'[A-Za-z_0-9%`~!@#$^&*()\[\]{}?/|\\><.,;"'№\-=+]')|((,|\.\.)\s*'''')|((,|\.\.)\s*#[0-9][0-9]?))*?\s*""") //ready
//
//    val thrd = Regex(""":\s*[A-Za-z_][A-Za-z_0-9]*\s*:=\s*('[A-Za-z_0-9%`~!@#$^&*()\[\]{}?/|\\><.,;"'№\-=+]*'|#[0-9][0-9]?|'''')+\s*;""")

//    println(frst.matches("CaSe vsd oF"))

    val resultRegex = Regex("""[Cc][Aa][Ss][Ee]\s[A-Za-z_][A-Za-z_0-9]*\s+[Oo][Ff]\s*?(('[^']'|''''|#[0-9][0-9]?)\s*(((,|\.\.)\s*'[A-Za-z_0-9%`~!@#$^&*()\[\]{}?/|\\><.,;"'№\-=+]')|((,|\.\.)\s*'''')|((,|\.\.)\s*#[0-9][0-9]?))*?\s*:\s*[A-Za-z_][A-Za-z_0-9]*\s*:=\s*('[A-Za-z_0-9%`~!@#$^&*()\[\]{}?/|\\><.,;"'№\-=+]*'|#[0-9][0-9]?|'''')+\s*;)+""")

    println(resultRegex.matches("case val of " +
            "'a'..'e'..'z' : vsdf := ''''#23;" +
            "'s', #54 : vfd := 'sdf';"))
}