#!/bin/bash

# Set the blame.ignoreRevsFile configuration
echo "Setting git blame ignore file..."
git config blame.ignoreRevsFile .git-blame-ignore-revs

# Create the .git/hooks/pre-commit file with Spotless check
echo "Creating pre-commit hook..."
cat > .git/hooks/pre-commit <<EOL
#!/bin/sh

# Run spotless:check before committing
echo "Running Spotless check..."
./mvnw spring-javaformat:validate

# Check if Spotless check failed
if [ \$? -ne 0 ]; then
  echo "Spotless check failed. Please format your code before committing."
  echo "run './mvnw spring-javaformat:apply'"
  echo "or install 'Spotless Applier' and press 'CTLR + SHIFT + ALT + ;' This will run './mvnw spotless:apply'"
  exit 1
fi

exit 0
EOL

# Make the pre-commit hook executable
echo "Making pre-commit hook executable..."
chmod +x .git/hooks/pre-commit

echo "Setup completed successfully!"