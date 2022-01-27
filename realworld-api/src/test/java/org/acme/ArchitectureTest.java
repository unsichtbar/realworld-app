package org.acme;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "org.acme")
public class ArchitectureTest {

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture()

            .layer("Domain").definedBy("org.acme.domain..")
            .layer("Application").definedBy("org.acme.application..")
            .layer("Infrastructure").definedBy("org.acme.infrastructure..")
            .layer("Presentation").definedBy("org.acme.presentation..")
            .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
            .whereLayer("Infrastructure").mayNotBeAccessedByAnyLayer()
            .whereLayer("Domain").mayOnlyBeAccessedByLayers("Application", "Infrastructure", "Presentation")
            .whereLayer("Application").mayOnlyBeAccessedByLayers("Infrastructure", "Presentation").because("""
                Domain layer should not depend on anything.
                Application layer should depend only on Domain.
                Infrastructure should never be depended on.
            """);

}