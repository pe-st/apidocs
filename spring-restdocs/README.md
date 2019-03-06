# Spring REST docs demo (inspired by Nicolas)

As Spring REST docs needs a running REST server, to set up the toolchain without spring is not easy

- `mvn clean package -Dmaven.test.skip=true`
- Deploy the WAR to your favourite AS
- `mvn package` (or run the unit test): this generates the snippets in `target/generated-snippets`
- Redeploy the WAR

Now you should be able to visit http://localhost:8080/somewhere to see the docs (didn't get it to work yet, though).
You can still load the the generated `index.html` manually in your browser, you'll find it in the WAR or in `targte/generated-docs`
