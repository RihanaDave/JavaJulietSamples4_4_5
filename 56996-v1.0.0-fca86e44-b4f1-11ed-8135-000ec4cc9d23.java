/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__fromFile_41.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-41.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * BadSink:  possibility of assertion being triggered
 * Flow Variant: 41 Data flow: data passed as an argument from one method to another in the same class
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE617_Reachable_Assertion__fromFile_41 extends AbstractTestCase
{

    private void bad_sink(String data ) throws Throwable
    {

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        File f = new File("C:\\data.txt");
        BufferedReader buffread = null;
        FileReader fread = null;
        try {
            /* read string from file into data */
            fread = new FileReader(f);
            buffread = new BufferedReader(fread);

            data = buffread.readLine(); // This will be reading the first "line" of the file, which
            // could be very long if there are little or no newlines in the file\
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( fread != null )
                    {
                        fread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing fread");
                }
            }
        }

        bad_sink(data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    private void goodG2B_sink(String data ) throws Throwable
    {

        /* POTENTIAL FLAW: assertion is evaluated */
        assert data.length() > 0;

    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        goodG2B_sink(data  );
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}
