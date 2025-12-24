import os
from PIL import Image

def upscale_images(input_dir, output_dir, target_size=(200, 200)):
    # Create the output directory if it doesn't exist
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    # Loop through all files in the input directory
    for filename in os.listdir(input_dir):
        # Ensure the file is an image (you can add more extensions if needed)
        if filename.endswith(('.png', '.jpg', '.jpeg', '.bmp', '.gif')):
            # Open the image file
            img_path = os.path.join(input_dir, filename)
            img = Image.open(img_path)

            # Resize the image to 200x200 using nearest neighbor interpolation
            upscaled_img = img.resize(target_size, Image.NEAREST)

            # Save the upscaled image in the output directory
            output_path = os.path.join(output_dir, filename)
            upscaled_img.save(output_path)

            print(f"Upscaled {filename} to {target_size} and saved to {output_path}")

# Example usage:
upscale_images('../src/main/resources/assets/methilmoreores/textures/item', 'item_upscale')
upscale_images('../src/main/resources/assets/methilmoreores/textures/block', 'block_upscale')
