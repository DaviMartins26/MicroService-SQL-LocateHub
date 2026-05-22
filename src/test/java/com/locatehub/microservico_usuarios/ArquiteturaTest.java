package com.locatehub.microservico_usuarios;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

// Analisa a raiz do projeto (com.locatehub) buscando as camadas
@AnalyzeClasses(packages = "com.locatehub")
public class ArquiteturaTest {

    @ArchTest
    public static final ArchRule controllers_nao_devem_ser_acessados_por_outras_camadas =
            classes().that().resideInAPackage("..controller..")
                    .should().onlyBeAccessed().byAnyPackage("..controller..", "..config..")
                    .because("Os controllers são a porta de entrada da API.");

    @ArchTest
    public static final ArchRule hierarquia_de_camadas_deve_ser_respeitada =
            layeredArchitecture().consideringAllDependencies()
                    .layer("Controller").definedBy("..controller..")
                    .layer("Domain").definedBy("..domain..")
                    .layer("Repository").definedBy("..repository..")

                    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Repository").mayOnlyBeAccessedByLayers("Domain", "Controller");
}