path=$1
oldName=$2
newName=$3
newFolderName=$4

if [ -z "$newFolderName" ]; then
    newFolderName=$newName
fi

filter=${f//$oldName/$newName}

cd $path

for f in *
do
  if [[ "$f" == *"$oldName"* ]]
  then
    if [ ! -d "../$newFolderName" ]; then
      mkdir "../$newFolderName"
    fi
    cp $f ../$newFolderName/${f//$oldName/$newName}
  fi
done

cd ../$newFolderName
sed -i '' "s/$oldName/$newName/g" *

echo "Copied all files"
