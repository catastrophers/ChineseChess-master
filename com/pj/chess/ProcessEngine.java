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
            process= Runtime.getRuntime().exec(new File(cmd).toString());
            stdin = process.getOutputStream();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void getInformation(String input)
    {
        input+="\n";
        try
        {
            stdin.write(input.getBytes());
            stdin.flush();
            String line = null;
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = br.readLine()) != null ) {
                //输出exe输出的信息以及错误信息
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }



}
