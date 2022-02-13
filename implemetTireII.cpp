struct Node
{
    Node *link[26];
    int cntEndsWith = 0;
    int cntPrefix = 0;
    bool flag = false;

    bool containsKey(char ch)
    {
        return link[ch - 'a'] != NULL;
    }

    void put(char ch, Node *node)
    {
        link[ch - 'a'] = node;
    }

    Node *get(char ch)
    {
        return link[ch - 'a'];
    }

    void increaseEnd()
    {
        cntEndsWith++;
    }

    void increasePrefix()
    {
        cntPrefix++;
    }

    void deleteEnd()
    {
        cntEndsWith--;
    }

    void reducePrefix()
    {
        cntPrefix--;
    }

    int getPrefix()
    {
        return cntPrefix;
    }

    int getEnd()
    {
        return cntEndsWith;
    }
};

class Trie
{
private:
    Node *root;

public:
    Trie()
    {
        root = new Node();
    }

    void insert(string &word)
    {
        Node *node = root;
        for (int i = 0; i < word.size(); i++)
        {
            if (!node->containsKey(word[i]))
                node->put(word[i], new Node());
            node = node->get(word[i]);
            node->increasePrefix();
        }
        node->increaseEnd();
    }

    int countWordsEqualTo(string &word)
    {
        Node *node = root;
        for (int i = 0; i < word.size(); i++)
        {
            if (node->containsKey(word[i]))
                node = node->get(word[i]);
            else
                return 0;
        }
        return node->getEnd();
    }

    int countWordsStartingWith(string &word)
    {
        Node *node = root;
        for (int i = 0; i < word.size(); i++)
        {
            if (node->containsKey(word[i]))
                node = node->get(word[i]);
            else
                return 0;
        }
        return node->getPrefix();
    }

    void erase(string &word)
    {
        Node *node = root;
        for (int i = 0; i < word.size(); i++)
        {
            if (node->containsKey(word[i]))
            {
                node = node->get(word[i]);
                node->reducePrefix();
            }
            else
                return;
        }
        node->deleteEnd();
    }
};
