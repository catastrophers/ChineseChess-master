package com.pj.chess;

import java.io.*;

public class ProcessEngine
{
    private Process process;
    private OutputStream stdin;
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
            stdin = process.getOutputStream();
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
            stdin.write(input.getBytes());
            stdin.flush();
            String line = null;
            String tmp = "";
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            brError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = br.readLine()) != null || (line = brError.readLine()) != null)
            {
                //输出exe输出的信息以及错误信息
                tmp = line;
            }
            return tmp;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }


}
