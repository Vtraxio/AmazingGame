package net.vtraxio.engineTester;

import net.vtraxio.renderEngine.DisplayManager;
import net.vtraxio.renderEngine.Loader;
import net.vtraxio.renderEngine.RawModel;
import net.vtraxio.renderEngine.Renderer;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

public class MainGameLoop {
    public static void main(String[] args) {
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        Renderer renderer = new Renderer();

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
            renderer.render(model);
            DisplayManager.updateDisplay();
        }

        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
