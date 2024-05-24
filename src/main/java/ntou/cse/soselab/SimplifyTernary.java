package ntou.cse.soselab;

import com.google.errorprone.refaster.annotation.AfterTemplate;
import com.google.errorprone.refaster.annotation.BeforeTemplate;
import org.openrewrite.java.template.RecipeDescriptor;

@RecipeDescriptor(
        name = "Simplify ternary expressions",
        description = "Simplifies various types of ternary expressions to improve code readability."
)
public class SimplifyTernary {
    @RecipeDescriptor(
            name = "Replace `booleanExpression ? true : false` with `booleanExpression`",
            description = "Replace ternary expressions like `booleanExpression ? true : false` with `booleanExpression`."
    )
    public static class SimplifyTernaryTrueFalse {

        @BeforeTemplate
        boolean before(boolean expr) {
            return expr;
        }

        @AfterTemplate
        boolean after(boolean expr) {
            return expr;
        }
    }

    @RecipeDescriptor(
            name = "Replace `booleanExpression ? false : true` with `!booleanExpression`",
            description = "Replace ternary expressions like `booleanExpression ? false : true` with `!booleanExpression`."
    )
    public static class SimplifyTernaryFalseTrue {

        @BeforeTemplate
        boolean before(boolean expr) {
            return !expr;
        }

        @AfterTemplate
        boolean after(boolean expr) {
            return !expr;
        }
    }
}
