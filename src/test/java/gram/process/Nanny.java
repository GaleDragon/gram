package gram.process;

import java.io.*;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: jeremymorgan
 * Date: 11/8/13
 * Time: 10:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Nanny {
    private static final int BLOCKSIZE = 50;

    public File tidy( File f ) throws IOException {
        FileWriter out = new FileWriter("cleaned.gram");
        HashMap<Integer, String[]> packaged = sort(f);
        for ( Integer i : packaged.keySet() ){
            String[] entry = packaged.get(i);
            out.write( entry[0] );
            out.write("\n");

            String seq = entry[1];
            int offset = 0;
            String sub = "";
            int seqLen = seq.length();
            while (true) {
                if ( offset + BLOCKSIZE > seqLen ){
                    String last = seq.substring(offset, seqLen);
                    out.write(last);
                    break;
                } else {
                    sub = seq.substring( offset, offset+BLOCKSIZE );
                    out.write( sub );
                    out.write("\n");
                    offset += BLOCKSIZE;
                }
            }
        }
        out.close();
        return new File("cleaned.gram");
    }

    public HashMap<Integer, String[]> sort( File f ) throws IOException{
        BufferedReader br = new BufferedReader( new FileReader(f) );
        HashMap<Integer, String[]> out = new HashMap<Integer, String[]>();
        int c;
        int bracket = (int) '>';
        int newline = (int) '\n';
        int flag = 0;
        String annotation = "";
        String sequence = "";
        String[] entry = new String[2];
        Integer i = 0;
        while ( (c = br.read()) != -1 ) {
            if (c == bracket){
                flag = 1;
                i += 1;
                if ( !sequence.equals("") ){
                    entry[1] = sequence;
                    out.put( i, entry );
                }
            }
            if (flag == 1) {
                if ( c == newline ){
                    entry[0] = annotation;
                    flag = 0;
                } else {
                    annotation += (char) c;
                }
            } else {
                sequence += (char) c;
            }
        }
        return out;
    }
}
