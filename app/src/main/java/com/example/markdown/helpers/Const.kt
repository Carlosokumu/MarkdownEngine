package com.example.markdown.helpers

object Const {


    const val  MD_SAMPLE = "# Solution to  Junior  Developer role -Http server\n" +
            "\n" +
            "\n" +
            "Writing an Http Server  in Golang.\n" +
            "\n" +
            "\n" +
            "The server serves like below:\n" +
            "\n" +
            "\n" +
            "![Server Demo](https://github.com/Carlosokumu/PesapalHttp/blob/master/demo/tcpwalk.gif)\n" +
            "\n" +
            "\n" +
            "**Background**\n" +
            "\n" +
            "     Design a basic HTTP web-server application which can listen on a configurable TCP port and serve both static HTML and \n" +
            "     dynamically generated HTML by means of a chosen programming language, such as in the way Apache uses PHP. \n" +
            "     It is acceptable for this server application to support only a restricted subset of HTTP, such as GET or POST requests, \n" +
            "     and the only headers it must support are Content-Type and Content-Length.\n" +
            "\n" +
            "**Prerequisite**\n" +
            "\n" +
            "You need to have the following to run the server in your machine:\n" +
            "- A basic Understanding of [Golang](https://go.dev/) and how to set up your [Go workspace.](https://go.dev/doc/gopath_code)\n" +
            "- Go installed in your machine\n" +
            "\n" +
            "\n" +
           ""


    const val Theme ="body {\n" +
            "    font-family: Helvetica, Arial, Freesans, clean, sans-serif;\n" +
            "padding:1em;\n" +
            "margin:auto;\n" +
            "max-width:42em;\n" +
            "background:#fefefe;\n" +
            "}\n" +
            "\n" +
            "h1, h2, h3, h4, h5, h6 {\n" +
            "    font-weight: bold;\n" +
            "}\n" +
            "\n" +
            "h1 {\n" +
            "    color: #000000;\n" +
            "    font-size: 28px;\n" +
            "}\n" +
            "\n" +
            "h2 {\n" +
            "    border-bottom: 1px solid #CCCCCC;\n" +
            "    color: #000000;\n" +
            "    font-size: 24px;\n" +
            "}\n" +
            "\n" +
            "h3 {\n" +
            "    font-size: 18px;\n" +
            "}\n" +
            "\n" +
            "h4 {\n" +
            "    font-size: 16px;\n" +
            "}\n" +
            "\n" +
            "h5 {\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "\n" +
            "h6 {\n" +
            "    color: #777777;\n" +
            "    background-color: inherit;\n" +
            "    font-size: 14px;\n" +
            "}\n" +
            "\n" +
            "hr {\n" +
            "    height: 0.2em;\n" +
            "    border: 0;\n" +
            "    color: #CCCCCC;\n" +
            "    background-color: #CCCCCC;\n" +
            "}\n" +
            "\n" +
            "p, blockquote, ul, ol, dl, li, table, pre {\n" +
            "    margin: 15px 0;\n" +
            "}\n" +
            "\n" +
            "code, pre {\n" +
            "    border-radius: 3px;\n" +
            "    background-color: #F8F8F8;\n" +
            "    color: inherit;\n" +
            "}\n" +
            "\n" +
            "code {\n" +
            "    border: 1px solid #EAEAEA;\n" +
            "    margin: 0 2px;\n" +
            "    padding: 0 5px;\n" +
            "}\n" +
            "\n" +
            "pre {\n" +
            "    border: 1px solid #CCCCCC;\n" +
            "    line-height: 1.25em;\n" +
            "    overflow: auto;\n" +
            "    padding: 6px 10px;\n" +
            "}\n" +
            "\n" +
            "pre > code {\n" +
            "    border: 0;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "}\n" +
            "\n" +
            "a, a:visited {\n" +
            "    color: #4183C4;\n" +
            "    background-color: inherit;\n" +
            "    text-decoration: none;\n" +
            "}"

    fun getScrollableData(): String {
        return "<p>(a) $\\frac{1}{18}$</p> <p>(b) $\\frac{7}{18}$</p> <p>(c) $\\frac{5}{18}$</p> <p>(d) $\\frac{1}{9}$</p> <p><!--more--></p> <p><strong>Ans: $\\frac{5}{18}$</strong></p> <p><strong>Solution</strong></p> <p>Hints : &#8211; Let, C be the event that &#8216;the difference of nos. shown is 1&#8217;</p> <p>\$C = \\left \\{ \\left ( 1, 2 \\right )\\left ( 2, 1 \\right )\\left ( 2, 3 \\right )\\left ( 3, 2 \\right )\\left ( 3, 4 \\right )\\left ( 4, 3 \\right )\\left ( 4, 5 \\right )\\left ( 5, 4 \\right )\\left ( 5, 6 \\right )\\left ( 6, 5 \\right ) \\right \\}$</p> <p>??? \$n\\left ( C \\right ) = 10$ , \$n\\left ( S \\right ) = 36$</p> <p>??? \$P\\left ( C \\right ) = \\frac{n\\left ( C \\right )}{n\\left ( S \\right )}$</p> <p>$=\\frac{10}{36}$</p> <p>$=\\frac{5}{18}$</p> <p><strong>Table Example:</strong></p> <table border=\"1\" style=\"border-collapse: collapse; width: 596px;\"> <tbody> <tr> <td style=\"width: 101px; text-align: center;\">$2x+y^{2}$</td> <td style=\"width: 127px; text-align: center;\">\$C = \\left \\{ \\left ( 1, 2 \\right )\\left ( 2, 1 \\right )\\left ( 2, 3 \\right )\\left ( 3, 2 \\right )\\left ( 3, 4 \\right )\\left ( 4, 3 \\right )\\left ( 4, 5 \\right )\\left ( 5, 4 \\right )\\left ( 5, 6 \\right )\\left ( 6, 5 \\right ) \\right \\}$</td> <td style=\"width: 168px; text-align: center;\">$\\large \\frac{12-n+5}{30\\left ( n-5 \\right )}=\\frac{1}{\\left ( n-4 \\right )\\left ( n-5 \\right )}$</td> <td style=\"width: 131px; text-align: center;\">$\\large \\frac{2}{5\\left ( n-5 \\right )}=\\frac{1}{\\left ( n-4 \\right )\\left ( n-5 \\right )}+\\frac{1}{30}$</td> </tr> <tr> <td style=\"width: 101px; text-align: center;\">Row 2 Column 1</td> <td style=\"width: 127px; text-align: center;\">Row 2 Column 2</td> <td style=\"width: 168px; text-align: center;\">Row 2 Column 3</td> <td style=\"width: 131px; text-align: center;\">Row 2 Column 4</td> </tr> <tr> <td style=\"width: 101px; text-align: center;\">Test</td> <td style=\"width: 127px; text-align: center;\">Test</td> <td style=\"width: 168px; text-align: center;\">$\\frac{5}{18}$</td> <td style=\"width: 131px; text-align: center;\"></td> </tr> </tbody> </table>"
    }
   fun  getNormalHtmlData(): String {
       return "<p>\n"+ "    As Xenophanes recognized as long ago as the sixth century before Christ,\n"+ "    whether or not God made man in His own image, it is certain that man makes\n"+ "    gods in his. The gods of Greek mythology first appear in the writings of\n"+ "    Homer and Hesiod, and, from the character and actions of these picturesque\n"+ "    and, for the most part, friendly beings, we get some idea of the men who\n"+ "    made them and brought them to Greece.\n"+ "</p>\n"+ "<p>\n"+ "    But ritual is more fundamental than mythology, and the study of Greek\n"+ "    ritual during recent years has shown that, beneath the belief or skepticism\n"+ "    with which the Olympians were regarded, lay an older magic, with\n"+ "    traditional rites for the promotion of fertility by the celebration of the\n"+ "    annual cycle of life and death, and the propitiation of unfriendly ghosts,\n"+ "    gods or demons. Against this dark and dangerous background arose Olympic\n"+ "    mythology on the one hand and early philosophy and science on the other.\n"+ "</p>\n"+ "<p>\n"+ "    In classical times the need of a creed higher than the Olympian was felt,\n"+ "    and Aeschylus, Sophocles and Plato finally evolved from the pleasant but\n"+ "    crude polytheism the idea of a single, supreme and righteous Zeus. But the\n"+ "    decay of Olympus led to a revival of old and the invasion of new magic\n"+ "    cults among the people, while some philosophers were looking to a vision of\n"+ "    the uniformity of nature under divine and universal law.\n"+ "</p>\n"+ "<p>\n"+ "    From Sir William Cecil Dampier, <em>A Shorter History of Science</em>,\n"+ "    ??1957, Meridian Books.\n"+ "</p>";
   }
    fun getMathWithDisplayStyle(): String? {
        return "$\\displaystyle {1 +  \\frac{q^2}{(1-q)}+\\frac{q^6}{(1-q)(1-q^2)}+\\cdots }= \\prod_{j=0}^{\\infty}\\frac{1}{(1-q^{5j+2})(1-q^{5j+3})}, \\quad\\quad \\text{for }\\lvert q\\rvert&lt;1.</annotation>$"
    }

}