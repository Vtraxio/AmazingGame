package net.vtraxio.shaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.lwjgl.opengl.GL20.*;

public abstract class ShaderProgram {
    private final int programID;
    private final int vertexShaderID;
    private final int fragmentShaderID;

    public ShaderProgram(String vertexFile, String fragmentFile) {
        vertexShaderID = loadShader(vertexFile, GL_VERTEX_SHADER);
        fragmentShaderID = loadShader(fragmentFile, GL_FRAGMENT_SHADER);

        programID = glCreateProgram();
        glAttachShader(programID, vertexShaderID);
        glAttachShader(programID, fragmentShaderID);
        glLinkProgram(programID);

        glValidateProgram(programID);
        bindAttributes();
    }

    private static int loadShader(String file, int type) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(file);
        assert inputStream != null;

        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        StringBuilder shaderSource = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line = reader.readLine()) != null) {
                shaderSource.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Could not read file!");
            e.printStackTrace();
            System.exit(-1);
        }

        int shaderID = glCreateShader(type);
        glShaderSource(shaderID, shaderSource);
        glCompileShader(shaderID);
        if (glGetShaderi(shaderID, GL_COMPILE_STATUS) == GL_FALSE) {
            System.err.println(glGetShaderInfoLog(shaderID, 500));
            System.err.println("Could not compile shader.");
            System.exit(-1);
        }

        return shaderID;
    }

    public void start() {
        glUseProgram(programID);
    }

    public void stop() {
        glUseProgram(0);
    }

    public void cleanUp() {
        stop();
        glDetachShader(programID, vertexShaderID);
        glDetachShader(programID, fragmentShaderID);
        glDeleteShader(vertexShaderID);
        glDeleteShader(fragmentShaderID);
        glDeleteProgram(programID);
    }

    protected abstract void bindAttributes();

    protected void bindAttribute(int attribute, String variableName) {
        glBindAttribLocation(programID, attribute, variableName);
    }
}
