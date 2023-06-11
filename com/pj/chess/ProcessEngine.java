package com.pj.chess;

import java.io.*;

public class ProcessEngine
{
    private Process process;
    private BufferedReader br = null;
    private BufferedReader brError = null;


    public ProcessEngine()
    {

    }

    public ProcessEngine(String cmd)
    {
        try
        {
            process = Runtime.getRuntime().exec(cmd);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String getInformation(String input)
    {
        input += "\n";
        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(input);
            writer.flush();
            String line = null;
            String tmp = "";
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            brError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            while ((line = br.readLine()) != null)
            {
                //输出exe输出的信息以及错误信息
                tmp = line;
                if(tmp.charAt(0)=='b')
                    break;
                System.out.println(tmp);
            }
            return tmp;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void writeCmd(String cmd)
    {
        cmd += "\n";
        try
        {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write(cmd);
            writer.flush();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
