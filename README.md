# elasticsearch-exclude-token-filter

## ElasticSearch version support
This plugin targets 1.X versions of ES, and won't work for 2.X.

## Install
To install on your current ES node, use the plugin binary provided in the bin folder (on Ubuntu it should be under `/usr/share/elasticsearch/bin`)

    bin/plugin -u https://github.com/zbagz/elasticsearch-exclude-token-filter/releases/download/v1.1.0/elasticsearch-exclude-1.1.0.zip -i concatenate
    
## Usage
The plugin provides a token filter of type `concatenate` which has one parameter `token_separator`. Use it in your custom analyzers to merge tokenized strings back into one single token (usually after applying stemming or other token filters).

## Example
Given the custom analyzer (see https://www.elastic.co/guide/en/elasticsearch/guide/current/custom-analyzers.html):

```javascript
{
  "analysis" : {
    "filter" : {
      "concatenate" : {
        "type" : "concatenate",
        "token_separator" : "_"
      },
      "custom_stop" : {
        "type": "stop",
        "stopwords": ["and", "is", "the"]
      }
    },
    "analyzer" : {
      "stop_concatenate" : {
        "filter" : [
          "custom_stop",
          "concatenate"
        ],
        "tokenizer" : "standard"
      }
    }
  }
}
```
the string:

    "The fox is a crafty and deceitful animal that never runs in a straight line, but only in circles. The fox is a scavenger carnivours dog, generally found in urban city areas in the northern Hemisphere"
    
would only allow:

    "fox" (2 times)
    
