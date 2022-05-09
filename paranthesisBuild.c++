#include <iostream>
using namespace std

    class paranthesisBuild
{
private:
    string word;

public:
    paranthesisBuild(string word)
    {
        this->word = word;
    }
};

int balanced()
{
    return -1;
}

int main()
{
    string word = "((((X))(((Y)))))";
    paranthesisBuild *obj = new paranthesisBuild();
    int ans = obj.balanced();

    cout << ans << endl;

    return 0;
}
