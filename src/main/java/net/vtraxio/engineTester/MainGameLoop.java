package net.vtraxio.engineTester;

import net.vtraxio.renderEngine.DisplayManager;
import net.vtraxio.renderEngine.Loader;
import net.vtraxio.renderEngine.RawModel;
import net.vtraxio.renderEngine.Renderer;
import net.vtraxio.shaders.StaticShader;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class MainGameLoop {
    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        StaticShader shader = new StaticShader();

        float[] vertices = {
                -0.5f, 0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f, 0.5f, 0.0f
        };

        int[] indices = {0, 1, 3, 3, 1, 2};

        RawModel model = loader.loadToVAO(vertices, indices);

        while (!glfwWindowShouldClose(DisplayManager.window)) {
            renderer.prepare();
            shader.start();
            renderer.render(model);
            shader.stop();
            DisplayManager.updateDisplay();
        }

        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
