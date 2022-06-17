#include <iostream>
#include <list>
#include <string>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);

    cin.tie(0);
	int N = 0;
	cin >> N;
	cin.ignore();

	for (int i = 0; i < N; i++)
	{
		string str;
		getline(cin, str);
		//cin.ignore();

		list<char> pwd;
		list<char>::iterator it = pwd.begin();

		for (int j = 0; j < str.size(); j++)
		{
			switch (str[j])
			{
			case '-':
				if (it != pwd.begin()) {
					it = pwd.erase(--it);
				}

				break;

			case '<':
				if (it != pwd.begin()) {
					it--;
				}
				break;

			case '>':
				if (it != pwd.end()) {
					it++;
				}
				break;

			default:
				pwd.insert(it, str[j]);
				break;
			}
		}

		for (char c : pwd)
		{
			cout << c;
		}
		cout << "\n";
	}
}