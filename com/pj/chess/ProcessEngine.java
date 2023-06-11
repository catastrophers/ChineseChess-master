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
            process= Runtime.getRuntime().exec(cmd);
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
                //���exe�������Ϣ�Լ�������Ϣ
                System.out.println(line);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }



}
