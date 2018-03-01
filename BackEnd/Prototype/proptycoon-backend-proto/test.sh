
echo "Generating Html test report"
mocha ./test/*.js --reporter mochawesome
echo "Generating Istanbul coverage"
nyc mocha