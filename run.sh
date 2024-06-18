echo "exportation of the Build Path........"
export PATH_TO_BUILD=build
echo "exportation of the javaFX Path......."
export PATH_TO_FX=lib/javaFx
echo "exportation of the controlsFX Path.........."
export PATH_TO_CONTROLSFX=lib/control
echo "exportation of all the modules Options........"
export MODULE_OPTIONS=javafx.controls,javafx.fxml,org.controlsfx.controls
echo "Attemp to effectively Run the project........"
java --module-path "$PATH_TO_FX:$PATH_TO_CONTROLSFX" --add-modules $MODULE_OPTIONS -jar Loan.jar
