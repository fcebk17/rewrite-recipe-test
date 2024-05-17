package ntou.cse.soselab;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;

class SayHelloRecipeTest implements RewriteTest {
    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new SayHelloRecipe("ntou.cse.soselab.FooBar"));
    }

    @Test
    void addsHelloToFooBar() {
        rewriteRun(
                java(
                        """
                            package ntou.cse.soselab;
        
                            class FooBar {
                            }
                        """,
                        """
                            package ntou.cse.soselab;
        
                            class FooBar {
                                public String hello() {
                                    return "Hello from ntou.cse.soselab.FooBar!";
                                }
                            }
                        """
                )
        );
    }

    @Test
    void doesNotChangeExistingHello() {
        rewriteRun(
                java(
                        """
                            package ntou.cse.soselab;
                
                            class FooBar {
                                public String hello() { return ""; }
                            }
                        """
                )
        );
    }

    @Test
    void doesNotChangeOtherClasses() {
        rewriteRun(
                java(
                        """
                            package ntou.cse.soselab;
                
                            class Bash {
                            }
                        """
                )
        );
    }
}