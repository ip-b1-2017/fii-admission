import json
import sys

with open(sys.argv[1]) as fin:
    forms = json.load(fin)
    with open(sys.argv[1] + '.plain', 'wb') as fout:
        for item in forms:
            fout.write(str(json.dumps(item, encoding="utf-8")
                           ).replace('"', "'") + '\n')
