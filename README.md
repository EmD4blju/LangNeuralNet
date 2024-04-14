## Task

Implement a 1-layer neural network that recognizes the language of the given text.

### Neural Network

The neural network has as many neurons as there are unique languages in the dataset. The neural network should recognize them based on the training data.

### Input Representation

The input vector represents the proportion of each ASCII letter in the given text.

#### Example:

- Input Text: "tools of ai"
- Vector: 1/9, 0, 0, 0, 0, 1/9, 0, 0, 1/9, 0, 0, 1/9, 0, 0, 1/3, 0, 0, 0, 1/9, 1/9, 0, 0, 0, 0, 0, 0

### Output

Each neuron calculates its linear output (net). Use a maximum selector to find which neuron is activated (1) and assume that the other neurons are not activated (0).

### Training

Apply the delta rule. After each learning step, weight vectors can be normalized to improve classification.

### Data

Create a dataset independently for training. Create 3-4 separate folders and name them according to languages (pl, en, de...). Each folder contains text files (10+) in a specific language - one file contains several paragraphs of text. Make sure the chosen language can be represented by ASCII characters.

### Testing

Provide an interface that allows inputting a short text to be classified by your program.
