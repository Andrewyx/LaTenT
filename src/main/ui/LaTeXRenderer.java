package ui;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.*;

/**
 * Responsible for all LaTex renderings and manipulation, Use for GUI to render LaTeX Symbols
 */
public class LaTeXRenderer {
    private String nextLatexItem;

    /**
     * REQUIRES: valid latex string
     * EFFECTS: Creates new render job for the given latex to be converted
     */
    public LaTeXRenderer(String latex) {
        this.nextLatexItem = latex;
        this.render();
    }

    /**
     * REQUIRES: nextLatexItem must be valid latex
     * MODIFIES: data/latex.png
     * EFFECTS: Renders the current active latex job
     */
    private void render() {
        TeXFormula formula = new TeXFormula(nextLatexItem);
        formula.createPNG(TeXConstants.STYLE_DISPLAY,20, "data/latex.png", Color.white, Color.black);
    }
}
