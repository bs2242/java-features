package com.bohdansavshak.java15_jep378_text_blocks;

public class Main {

  /*
     Text Blocks

     Easier way to work with multi line strings.

  */

  public static void main(String[] args) {
    String html1 =
        "<html>\n"
            + "    <body>\n"
            + "        <p>Hello, world</p>\n"
            + "    </body>\n"
            + "</html>\n";
    // above you can see one dimensional string literals

    String html2 =
        """
                        <html>
                            <body>
                                <p>Hello, world</p>
                            </body>
                        </html>
                        """;
    // above you can see two dimensional block of text
    // text block is a new string literal. Basically you can use it wherever string literal is
    // expected.

    // opening delimiter """ may have zero or more whitespaces but it must have line terminator
    String html3 =
        """
                        <html>
                            <body>
                                <p>Hello, world</p>
                            </body>
                        </html>
                        """;

    String emptyString = """
                """;

    //        String thisWillNotCompile = """ """;

    String identation =
        """
                        Hello, Brian

                        My sentence

                        Best regards,
                        Bohdan
                        """;
    System.out.println(identation);

    String identation2 =
        """
                         Hello, Brian +

                         My sentence

                         Best regards,
                         Bohdan
                        """;
    System.out.println(identation2);

    // example of \s escape char for space. at the end of the line. Be
    String identation3 =
        """
                         Hello, Brian +\s

                         My sentence

                         Best regards,
                         Bohdan
                        """;
    System.out.println(identation3);

    // example of backslash escape char.
    String identation4 =
        """
                        Hello, \
                        Brian My \
                        sentence \
                        Best regards, \
                        Bohdan
                        """;
    System.out.println(identation4);
  }
}
