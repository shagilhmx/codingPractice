#include <iostream>
using namespace std;

/*
The statement ComplexNumber c3 = c1 + c2; is internally translated as ComplexNumber c3 = c1.operator+ (c2); in order to invoke the operator function. The argument c1 is implicitly passed using the ‘.’ operator. The next statement also makes use of the dot operator to access the member function print and pass c3 as an argument.
*/
class ComplexNumber
{
private:
    int real, imiganiry;

public:
    ComplexNumber(int real, int imiganiry)
    {
        this->real = real;
        this->imiganiry = imiganiry;
    }

    void print()
    {
        cout << real << " + i" << imiganiry << endl;
    }

    ComplexNumber operator+(ComplexNumber c2)
    {
        cout << c2.real << " + i" << c2.imiganiry << endl;
        ComplexNumber c3(0, 0);
        c3.real = this->real + c2.real;
        c3.imiganiry = this->imiganiry + c2.imiganiry;
        return c3;
    }
};

int main()
{
    ComplexNumber c1(3, 5);
    ComplexNumber c2(2, 4);
    ComplexNumber c3 = c1 + c2;

    c3.print();

    return 0;
}